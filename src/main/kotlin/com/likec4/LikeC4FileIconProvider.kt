package com.likec4

import com.intellij.ide.IconProvider
import com.intellij.psi.PsiElement
import javax.swing.Icon
import com.intellij.psi.PsiFile

class LikeC4FileIconProvider : IconProvider() {

  override fun getIcon(element: PsiElement, flags: Int): Icon? {
    if (element is PsiFile && element.virtualFile?.extension in supportedExtensions) {
      return LikeC4Icons.LikeC4
    }
    return null
  }

}
