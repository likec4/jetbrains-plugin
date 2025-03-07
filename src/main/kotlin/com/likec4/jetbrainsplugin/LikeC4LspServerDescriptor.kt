package com.likec4.jetbrainsplugin

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor

class LikeC4LspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, "LikeC4") {

  override fun isSupportedFile(file: VirtualFile): Boolean = file.extension in supportedExtensions

  override fun createCommandLine(): GeneralCommandLine = GeneralCommandLine("likec4-language-server", "--stdio")

}
