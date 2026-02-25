package likec4.plugin.lang

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiFile
import likec4.plugin.icon.LikeC4Icons
import org.jetbrains.plugins.textmate.TextMateBackedFileType
import org.jetbrains.plugins.textmate.TextMateFileType
import javax.swing.Icon
import kotlin.collections.contains

object LikeC4FileType  :  LanguageFileType(LikeC4Language), TextMateBackedFileType {
    override fun getName() = likeC4Name
    override fun getDefaultExtension() = "c4"
    override fun getIcon(): Icon = LikeC4Icons.LikeC4
//    override fun isBinary() = false

    override fun getDescription() =
        "LikeC4 DSL"

    fun isMyFile(file: PsiFile) = isMyFile(file.virtualFile)

    fun isMyFile(file: VirtualFile) =
        file.fileType == TextMateFileType.INSTANCE && file.extension in supportedExtensions
}
