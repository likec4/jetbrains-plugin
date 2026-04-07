package likec4.plugin.lsp

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor
import com.intellij.platform.lsp.api.customization.LspCustomization
import com.intellij.platform.lsp.api.customization.LspSemanticTokensSupport
import com.intellij.testFramework.LightVirtualFile
import likec4.plugin.lang.LikeC4FileType
import likec4.plugin.lang.languageID
import likec4.plugin.lang.likeC4Name
import org.eclipse.lsp4j.SemanticTokenTypes
import java.net.URI

class LikeC4LspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, likeC4Name) {

    override val lspCustomization = object : LspCustomization() {
        override val semanticTokensCustomizer = object : LspSemanticTokensSupport() {
            override fun getTextAttributesKey(tokenType: String, modifiers: List<String>) =
                when (tokenType) {
                    // Changing colors for better appearance and consistency in IntelliJ IDE
                    SemanticTokenTypes.Enum -> DefaultLanguageHighlighterColors.METADATA

                    else -> super.getTextAttributesKey(tokenType, modifiers)
                }
        }
    }

    override fun getLanguageId(file: VirtualFile): String = languageID

    override fun findFileByUri(fileUri: String ): VirtualFile? {
        if (fileUri.startsWith("likec4builtin")) {
            val uri = URI(fileUri)
            return LightVirtualFile(
                uri.path,
                LikeC4FileType,
                "// LikeC4 Built-in\n"
            )
        }
        return  super.findFileByUri(fileUri)
    }
    override fun isSupportedFile(file: VirtualFile) = LikeC4LspServerDescriptor.isSupportedFile(file)

    override fun createCommandLine(): GeneralCommandLine =
        GeneralCommandLine("npx")
            .withParameters("@likec4/lsp", "--yes", "--stdio")
            .withParentEnvironmentType(GeneralCommandLine.ParentEnvironmentType.CONSOLE)

//    override val lspCommunicationChannel = LspCommunicationChannel.Socket(11233)

    companion object {

        fun isSupportedFile(file: VirtualFile) =  LikeC4FileType.isMyFile(file)

    }
}
