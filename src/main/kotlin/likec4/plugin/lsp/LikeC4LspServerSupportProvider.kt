package likec4.plugin.lsp

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServer
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.platform.lsp.api.LspServerSupportProvider.LspServerStarter
import com.intellij.platform.lsp.api.lsWidget.LspServerWidgetItem
import likec4.plugin.icon.LikeC4Icons
import likec4.plugin.lang.supportedExtensions

class LikeC4LspServerSupportProvider : LspServerSupportProvider {
  override fun fileOpened(project: Project, file: VirtualFile, serverStarter: LspServerStarter) {
    if (file.extension in supportedExtensions) {
      if (LikeC4LanguageServerInstaller.ensureAvailable(project)) {
        serverStarter.ensureServerStarted(LikeC4LspServerDescriptor(project))
      }
    }
  }

  override fun createLspServerWidgetItem(lspServer: LspServer, currentFile: VirtualFile?): LspServerWidgetItem? =
    LspServerWidgetItem(lspServer, currentFile, LikeC4Icons.LikeC4, null)
}
