package dev.likec4.jetbrainsplugin.tests

import com.intellij.testFramework.TestDataPath
import com.intellij.testFramework.builders.ModuleFixtureBuilder
import com.intellij.testFramework.fixtures.CodeInsightFixtureTestCase
import com.intellij.testFramework.fixtures.ModuleFixture
import com.intellij.testFramework.fixtures.impl.CodeInsightTestFixtureImpl

@TestDataPath("\$CONTENT_ROOT/src/test/testData")
class LikeC4HighlightingTest : CodeInsightFixtureTestCase<ModuleFixtureBuilder<ModuleFixture>>() {
  override fun setUp() {
    super.setUp()
    (myFixture as CodeInsightTestFixtureImpl).canChangeDocumentDuringHighlighting(true)
    myFixture.testDataPath = "src/test/testData/highlighting"
  }

  fun testUnresolvedReference() {
//    myFixture.configureByFile(getTestName(true) + ".c4")
    myFixture.configureByFile(getTestName(true) + ".likec4")
    myFixture.checkLspHighlighting()
  }
}
