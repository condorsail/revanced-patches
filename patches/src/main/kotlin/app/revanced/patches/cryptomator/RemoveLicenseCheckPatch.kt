package app.revanced.patches.cryptomator.license

import app.revanced.patcher.extensions.InstructionExtensions.removeInstruction
import app.revanced.patcher.patch.bytecodePatch
import com.android.tools.smali.dexlib2.Opcode
import com.android.tools.smali.dexlib2.iface.instruction.ReferenceInstruction

@Suppress("unused")
val removeLicenseCheckPatch = bytecodePatch(
    name = "Remove license check",
    description = "Removes the License Check to enable usage of app"
) {
    compatibleWith("org.cryptomator")

    execute {
        licenseCheckInvokeFingerprint.method.apply {
            val instructions = implementation!!.instructions

            val targetIndex = instructions.indexOfFirst {
                it.opcode == Opcode.INVOKE_DIRECT &&
                (it as? ReferenceInstruction)?.reference?.toString() ==
                    "Lorg/cryptomator/presentation/presenter/VaultListPresenter;->checkLicense()V"
            }

            check(targetIndex != -1) { "checkLicense() invoke-direct not found." }

            // Remove just that instruction
            removeInstruction(targetIndex)
        }
    }
}

