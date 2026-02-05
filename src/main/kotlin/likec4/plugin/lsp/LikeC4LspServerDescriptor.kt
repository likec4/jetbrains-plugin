package likec4.plugin.lsp

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor

import likec4.plugin.lang.likeC4Name
import likec4.plugin.lang.supportedExtensions

class LikeC4LspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, likeC4Name) {

    override fun isSupportedFile(file: VirtualFile): Boolean = file.extension in supportedExtensions

    override fun createCommandLine(): GeneralCommandLine = GeneralCommandLine("likec4-language-server", "--stdio")

}
