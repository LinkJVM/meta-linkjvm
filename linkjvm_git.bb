inherit cmake

SRC_URI = "git://github.com/LinkJVM/LinkJVM.git"

DEPENDS = "libkovan libkovan-dev"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "kovan"
SRCREV = "HEAD"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=5db6e3eeebad5526401d10dc7221871f"
PR = "linkjvm_1.2.0-0001"

EXTRA_OECMAKE = "--no-warn-unused-cli -DKOVAN=1 -DCMAKE_BUILD_TYPE=Debug"

OECMAKE_SOURCEPATH = "${S}"