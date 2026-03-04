package likec4.plugin.lsp

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServer
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.platform.lsp.api.LspServerSupportProvider.LspServerStarter
import com.intellij.platform.lsp.api.lsWidget.LspServerWidgetItem
import likec4.plugin.icon.LikeC4Icons

class LikeC4LspServerSupportProvider : LspServerSupportProvider {
  override fun fileOpened(project: Project, file: VirtualFile, serverStarter: LspServerStarter) {

    if (!LikeC4LspServerDescriptor.isSupportedFile(file)) return

    try {
      if (!LikeC4LanguageServerInstaller.ensureAvailable(project)) return
    } catch (e: Exception) {
      e.printStackTrace()
    }

    serverStarter.ensureServerStarted(LikeC4LspServerDescriptor(project))
  }

  override fun createLspServerWidgetItem(lspServer: LspServer, currentFile: VirtualFile?) =
    LspServerWidgetItem(lspServer, currentFile, LikeC4Icons.LikeC4)
}
