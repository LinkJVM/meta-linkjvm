inherit cmake

SRC_URI = "git://github.com/LinkJVM/LinkJVM.git"

DEPENDS = "libkovan"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "kovan"
SRCREV = "HEAD"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=5db6e3eeebad5526401d10dc7221871f"
PR = "r1"
HAMEPAGE = "http://LinkJVM.github.io/LinkJVM"

EXTRA_OECMAKE = "--no-warn-unused-cli -DKOVAN=1 -DCMAKE_BUILD_TYPE=Debug"

OECMAKE_SOURCEPATH = "${S}"

do_install() {
	install -d ${D}/usr/lib
	install -m 0755 ${S}/lib/linkjvm.so ${D}/usr/lib
	install -m 0755 ${S}/lib/linkjvm.jar ${D}/usr/lib
	
	install -d ${D}/usr
	install -m 0755 ${S}/java-environment/jamvm/* ${D}/usr
	install -m 0755 ${S}/java-environment/classpath/* ${D}/usr
	install -d ${D}/usr/lib/ecj
	install -m 0755 ${S}/java-environment/javac/ecj-3.7.jar ${D}/usr/lib/ecj
}

FILES_${PN} += "${libdir}/linkjvm.so"
FILES_${PN} += "${libdir}/linkjvm.jar"

FILES_${PN} += "${bindir}/jamvm"
FILES_${PN} += "${includedir}/jni.h"
FILES_${PN} += "${libdir}/libjvm.la"
FILES_${PN} += "${libdir}/libjvm.so"
FILES_${PN} += "${libdir}/libjvm.so.0"
FILES_${PN} += "${libdir}/libjvm.so.0.0.0"
FILES_${PN} += "${libdir}/rt.jar"
FILES_${PN} += "${datadir}/jamvm"

FILES_${PN} += "${includedir}/jawt.h"
FILES_${PN} += "${includedir}/jawt_md.h"
FILES_${PN} += "${includedir}/jni_md.h"
FILES_${PN} += "${libdir}/classpath"
FILES_${PN} += "${datadir}/classpath"

FILES_${PN} += "${libdir}/ecj"