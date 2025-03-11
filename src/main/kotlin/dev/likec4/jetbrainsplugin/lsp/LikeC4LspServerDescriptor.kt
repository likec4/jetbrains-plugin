package dev.likec4.jetbrainsplugin.lsp

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor

import dev.likec4.jetbrainsplugin.lang.likeC4Name
import dev.likec4.jetbrainsplugin.lang.supportedExtensions

class LikeC4LspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, likeC4Name) {

    override fun isSupportedFile(file: VirtualFile): Boolean = file.extension in supportedExtensions

    override fun createCommandLine(): GeneralCommandLine = GeneralCommandLine("likec4-language-server", "--stdio")

}
