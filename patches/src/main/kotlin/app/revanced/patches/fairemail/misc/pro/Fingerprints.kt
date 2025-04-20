package app.revanced.patches.fairemail.misc.pro

import app.revanced.patcher.fingerprint

internal val forceProFingerprint = fingerprint {
    custom { method, classDef ->
        classDef.type =="Leu/faircode/email/ActivityBilling;" &&
        method.name == "isPro" &&
        method.parameters.size == 1 &&
        method.parameters[0].type == "Landroid/content/Context;" &&
        method.returnType == "Z"
    }
}

