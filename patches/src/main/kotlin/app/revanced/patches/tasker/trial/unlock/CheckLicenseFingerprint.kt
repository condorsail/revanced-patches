package app.revanced.patches.tasker.trial.unlock

import app.revanced.patcher.fingerprint

internal val checkLicenseFingerprint = fingerprint {
    strings("Can't check license")
}
