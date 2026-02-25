package likec4.plugin.textmate

import com.intellij.openapi.application.PluginPathManager
import org.jetbrains.plugins.textmate.api.TextMateBundleProvider

class LikeC4TextMateBundleProvider : TextMateBundleProvider {

    override fun getBundles() =
        PluginPathManager.getPluginResource(javaClass, "textmate/bundles/likec4")
            ?.let { listOf(TextMateBundleProvider.PluginBundle("likec4", it.toPath())) }
            ?: emptyList()

}