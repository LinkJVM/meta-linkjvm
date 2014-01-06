inherit cmake

SRC_URI = "git://github.com/LinkJVM/LinkJVM.git"

DEPENDS = "libkovan"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "kovan"
SRCREV = "develop"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${S}/LICENSE.txt;md5=5db6e3eeebad5526401d10dc7221871f"
PR = "r0"
HOMEPAGE = "http://linkjvm.github.io"
AUTOR="Markus Klein"
DESCRIPTION="Java on the KIPR Link"
MAINTAINER="m@mklein.co.at"

EXTRA_OECMAKE = "--no-warn-unused-cli -DKOVAN=1 -DCMAKE_BUILD_TYPE=Debug"

OECMAKE_SOURCEPATH = "${S}"

do_install() {
        install -d ${D}/usr/lib
        install -m 0755 ${S}/lib/liblinkjvmjni.so ${D}/usr/lib
        install -m 0755 ${S}/lib/linkjvmjava.jar ${D}/usr/lib
        
        install -d ${D}/usr
        cp -r ${S}/java-environment/jamvm/* ${D}/usr
        cp -r ${S}/java-environment/classpath/* ${D}/usr
        install -d ${D}/usr/lib/ecj
	install -m 0755 ${S}/java-environment/javac/ecj-3.7.jar ${D}/usr/lib/ecj
        install -m 0755 ${S}/bin/javac ${D}/usr/bin
	install -m 0755 ${S}/bin/jar ${D}/usr/bin
	chmod +x ${D}/usr/bin/java
}

FILES_${PN} += "${libdir}/liblinkjvmjni.so"
FILES_${PN} += "${libdir}/linkjvmjava.jar"

FILES_${PN} += "${bindir}/java"
FILES_${PN} += "${bindir}/java"
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
FILES_${PN} += "${bindir}/javac"
FILES_${PN} += "${bindir}/jar"
