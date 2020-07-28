package com.squareup.anvil.compiler.codegen

import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.psi.KtFile
import java.io.File

internal interface CodeGenerator {
  /**
   * Called multiple times in order to create new code. Note that instances should not rely on
   * being able to resolve [projectFiles] to descriptors. They should rather use the Psi APIs to
   * parse files.
   *
   * In the first round code generators are called with the files from the project. In following
   * rounds [projectFiles] represents files that were generated by code generators until no
   * code generator produces any files anymore.
   */
  fun generateCode(
    codeGenDir: File,
    module: ModuleDescriptor,
    projectFiles: Collection<KtFile>
  ): Collection<GeneratedFile>

  /**
   * Called after the last round of [generateCode] when no new files were produced by any code
   * generator anymore.
   */
  fun flush(
    codeGenDir: File,
    module: ModuleDescriptor
  ) = Unit

  data class GeneratedFile(
    val file: File,
    val content: String
  )
}
