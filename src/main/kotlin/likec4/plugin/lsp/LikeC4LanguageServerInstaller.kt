package likec4.plugin.lsp

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.configurations.GeneralCommandLine.ParentEnvironmentType
import com.intellij.execution.util.ExecUtil
import com.intellij.notification.NotificationAction
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.ide.CopyPasteManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.SystemInfo
import likec4.plugin.icon.LikeC4Icons
import java.awt.datatransfer.StringSelection

object LikeC4LanguageServerInstaller {
  private const val executableName = "likec4"
  private const val installCommand = "npm install -g likec4"
  private val notifiedKey = Key.create<Boolean>("likec4.language.server.missing.notified")

  private var _isAvailable = false

  fun ensureAvailable(project: Project): Boolean {
    if (_isAvailable || isAvailable()) {
      _isAvailable = true
      return true
    }

    if (project.getUserData(notifiedKey) != true) {
      project.putUserData(notifiedKey, true)
      notifyMissingServer(project)
    }
    return false
  }

  private fun isAvailable(): Boolean {
    val paths = System.getenv("PATH")?.split(System.getProperty("path.separator")) ?: return false
    val extensions = if (SystemInfo.isWindows) listOf(".cmd", ".bat", ".exe", "") else listOf("")
    
    return paths.any { pathDir ->
      extensions.any { ext ->
        val executablePath = java.nio.file.Paths.get(pathDir, executableName + ext)
        java.nio.file.Files.isExecutable(executablePath)
      }
    }
  }

  private fun notifyMissingServer(project: Project) {
    val notification = NotificationGroupManager.getInstance()
      .getNotificationGroup("LikeC4")
      .createNotification(
        "LikeC4 CLI not found",
        "Install <code>likec4</code> to enable LikeC4 support.",
        NotificationType.WARNING
      )
      .setIcon(LikeC4Icons.LikeC4)

    notification.addAction(NotificationAction.createSimpleExpiring("Install with npm") {
      val result = Messages.showYesNoDialog(
        project,
        "Run \"$installCommand\"?",
        "Install LikeC4 Language Server",
        Messages.getQuestionIcon()
      )
      if (result == Messages.YES) {
        installLanguageServer(project)
      }
    })

    notification.addAction(NotificationAction.createSimpleExpiring("Copy install command") {
      CopyPasteManager.getInstance().setContents(StringSelection(installCommand))
    })

    notification.notify(project)
  }

  private fun installLanguageServer(project: Project) {
    ApplicationManager.getApplication().executeOnPooledThread {
      val (message, details, type) = try {
        val output = ExecUtil.execAndGetOutput(buildInstallCommandLine())
        if (output.exitCode == 0) {
          Triple("LikeC4 language server installed.", output.stdout, NotificationType.INFORMATION)
        } else {
          Triple(
            "Failed to install LikeC4 language server (exit code ${output.exitCode}).",
            output.stderr.ifBlank { output.stdout },
            NotificationType.ERROR
          )
        }
      } catch (exception: ExecutionException) {
        Triple(
          "Failed to install LikeC4 language server.",
          exception.localizedMessage ?: "npm is not available or failed to run.",
          NotificationType.ERROR
        )
      }

      NotificationGroupManager.getInstance()
        .getNotificationGroup("LikeC4")
        .createNotification(message, details, type)
        .setIcon(LikeC4Icons.LikeC4)
        .notify(project)
    }
  }

  private fun buildInstallCommandLine(): GeneralCommandLine {
    val baseCommand = listOf("npm", "install", "-g", "likec4")
    val commandLine = if (SystemInfo.isWindows) {
      GeneralCommandLine("cmd.exe", "/c").withParameters(baseCommand)
    } else {
      GeneralCommandLine(baseCommand)
    }
    return commandLine.withParentEnvironmentType(ParentEnvironmentType.CONSOLE)
  }
}
