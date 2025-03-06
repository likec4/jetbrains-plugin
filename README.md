# jetbrains-likec4-plugin

![Build](https://github.com/likec4/jetbrains-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/<MARKETPLACE_ID>.svg)](https://plugins.jetbrains.com/plugin/<MARKETPLACE_ID>)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/<MARKETPLACE_ID>.svg)](https://plugins.jetbrains.com/plugin/<MARKETPLACE_ID>)

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [x] Get familiar with the [template documentation][template].
- [x] Adjust the [pluginGroup](./gradle.properties) and [pluginName](./gradle.properties), as well as the [id](./src/main/resources/META-INF/plugin.xml) and [sources package](./src/main/kotlin).
- [x] Adjust the plugin description in `README` (see [Tips][docs:plugin-description])
- [x] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html?from=IJPluginTemplate).
- [ ] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [ ] Set the `MARKETPLACE_ID` in the above README badges. You can obtain it once the plugin is published to JetBrains Marketplace.
- [ ] Set the [Plugin Signing](https://plugins.jetbrains.com/docs/intellij/plugin-signing.html?from=IJPluginTemplate) related [secrets](https://github.com/JetBrains/intellij-platform-plugin-template#environment-variables).
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html?from=IJPluginTemplate).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
Enhance your JetBrains IDE with LikeC4 support to work seamlessly with architecture-as-code models.

This plugin integrates [LikeC4](https://likec4.dev), a powerful toolchain and Domain-Specific Language (DSL) for defining architecture diagrams as code, into JetBrains IDEs. It leverages the [@likec4/language-server](https://github.com/likec4/likec4/tree/main/packages/language-server), utilizing the [LSP API](https://plugins.jetbrains.com/docs/intellij/language-server-protocol.html) to provide essential features like:

- **Syntax highlighting** and **code completion** for LikeC4 DSL
- **Real-time validation** and **error checking**
- **Navigation and symbol lookup** within architecture models
- **Live diagram updates** based on model changes

With this plugin, you can efficiently manage your architecture models directly within your JetBrains IDE, ensuring your diagrams remain up-to-date with your code.

## 🔗 Resources
- **LikeC4 Website:** [likec4.dev](https://likec4.dev)
- **Plugin Source Code:** [GitHub Repository](https://github.com/likec4/jetbrains-plugin)
- **Issue Tracker:** [Report a Bug / Request a Feature](https://github.com/likec4/jetbrains-plugin/issues)

<!-- Plugin description end -->

## Installation

- Prepare environment:
  + Install [@likec4/language-server](https://github.com/likec4/likec4/tree/main/packages/language-server)
    ```shell
    npm install -g @likec4/language-server
    ```

- Using the IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "jetbrains-likec4-plugin"</kbd> >
  <kbd>Install</kbd>
  
- Using JetBrains Marketplace:

  Go to [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID) and install it by clicking the <kbd>Install to ...</kbd> button in case your IDE is running.

  You can also download the [latest release](https://plugins.jetbrains.com/plugin/MARKETPLACE_ID/versions) from JetBrains Marketplace and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

- Manually:

  Download the [latest release](https://github.com/likec4/jetbrains-plugin/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
