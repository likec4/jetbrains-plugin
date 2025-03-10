package com.likec4.jetbrainsplugin

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object LikeC4FileType : LanguageFileType(LikeC4Language) {
    override fun getName() = "LikeC4"
    override fun getDefaultExtension() = "c4"
    override fun getIcon(): Icon = LikeC4Icons.LikeC4
    override fun getDescription() =
        "LikeC4 model file for architecture-as-code, " +
                "enabling structured system modeling with live diagram generation and version control."
}
