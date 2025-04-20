package app.revanced.patches.cryptomator.license

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.Opcode

internal val licenseCheckInvokeFingerprint = fingerprint {
    custom { method, classDef ->
        classDef.type == "Lorg/cryptomator/presentation/presenter/VaultListPresenter;" &&
        method.name == "prepareView" == true
    }
}
