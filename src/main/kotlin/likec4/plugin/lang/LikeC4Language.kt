package likec4.plugin.lang

import com.intellij.lang.Language

object LikeC4Language : Language(likeC4Name) {
    private fun readResolve(): Any = LikeC4Language
}
