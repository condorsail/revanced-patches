package app.revanced.patches.fairemail.misc.pro

import app.revanced.patcher.extensions.InstructionExtensions.addInstructions
import app.revanced.patcher.patch.bytecodePatch

@Suppress("unused")
val forceProPatch = bytecodePatch(
    name = "Force Pro Mode",
    description = "Forces FairEmail to always recognize the user as Pro.",
) {
    compatibleWith("eu.faircode.email")

    execute {
        forceProFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """.trimIndent()
        )
    }
}

