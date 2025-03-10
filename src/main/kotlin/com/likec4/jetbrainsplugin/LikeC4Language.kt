package com.likec4.jetbrainsplugin

import com.intellij.lang.Language

object LikeC4Language : Language("LikeC4") {
    private fun readResolve(): Any = LikeC4Language
    override fun toString(): String {
        return "LikeC4"
    }
}
