package likec4.plugin.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import likec4.plugin.icon.LikeC4Icons
import javax.swing.Icon

class LikeC4FileType : LanguageFileType(LikeC4Language) {
    override fun getName() = likeC4Name
    override fun getDefaultExtension() = "c4"
    override fun getIcon(): Icon = LikeC4Icons.LikeC4
    override fun getDescription() =
        "LikeC4 model file for architecture-as-code, " +
                "enabling structured system modeling with live diagram generation and version control."
}
