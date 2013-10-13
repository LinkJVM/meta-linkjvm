inherit cmake

SRC_URI = "git://github.com/LinkJVM/LinkJVM.git"

DEPENDS = "libkovan"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "kovan"
SRCREV = "HEAD"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${S}/LICENSE.txt;md5=5db6e3eeebad5526401d10dc7221871f"
PR = "r27"
HAMEPAGE = "http://LinkJVM.github.io/LinkJVM"

EXTRA_OECMAKE = "--no-warn-unused-cli -DKOVAN=1 -DCMAKE_BUILD_TYPE=Debug"

OECMAKE_SOURCEPATH = "${S}"

do_install() {
	install -d ${D}/usr
	install -d ${D}/usr/lib
	install -d ${D}/usr/bin
	install -d ${D}/usr/include
	install -d ${D}/usr/share
	
	#linkjvm libs
	install -m 0755 ${S}/lib/liblinkjvm-jni.so ${D}/usr/lib
	install -m 0755 ${S}/lib/linkjvm-java.jar ${D}/usr/lib
	
	#ecj
	install -d ${D}/usr/lib/ecj
	install -m 0755 ${S}/java-environment/javac/ecj-3.7.jar ${D}/usr/lib/ecj
	
	#jamvm
	install -m 0755 ${S}/java-environment/jamvm/bin/jamvm ${D}/usr/bin
	install -m 0755 ${S}/java-environment/jamvm/lib/libjvm.la ${D}/usr/lib
	install -m 0755 ${S}/java-environment/jamvm/lib/libjvm.so ${D}/usr/lib
	install -m 0755 ${S}/java-environment/jamvm/lib/libjvm.so.0 ${D}/usr/lib
	install -m 0755 ${S}/java-environment/jamvm/lib/libjvm.so.0.0.0 ${D}/usr/lib
	install -m 0755 ${S}/java-environment/jamvm/lib/rt.jar ${D}/usr/lib
	install -m 0755 ${S}/java-environment/jamvm/include/jni.h ${D}/usr/include	
	install -d ${D}/usr/share/jamvm
	install -m 0644 ${S}/java-environment/jamvm/share/jamvm/classes.zip ${D/usr/share/jamvm
	
	#classpath
	install -d ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libgconfpeer.la ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libgconfpeer.so ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libgtkpeer.la ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libgtkpeer.so ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavaio.la ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavaio.so ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavaio.so.0 ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavaio.so.0.0.0 ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavalang.la ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavalang.so ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavalang.so.0 ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavalang.so.0.0.0 ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavalangmanagement.la ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavalangmanagement.so ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavalangmanagement.so.0 ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavalangmanagement.so.0.0.0 ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavalangreflect.la ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavalangreflect.so ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavalangreflect.so.0 ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavalangreflect.so.0.0.0 ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavamath.la ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavamath.so ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavanet.la ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavanet.so ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavanet.so.0 ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavanet.so.0.0.0 ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavanio.la ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavanio.so ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavanio.so.0 ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavanio.so.0.0.0 ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavautil.la ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavautil.so ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavautil.so.0 ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjavautil.so.0.0.0 ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjawt.la ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/lib/libjawt.so ${D}/usr/lib/classpath
	install -m 0755 ${S}/java-environment/classpath/include/jawt.h ${D}/usr/include
	install -m 0755 ${S}/java-environment/classpath/include/jawt_md.h ${D}/usr/include
	install -m 0755 ${S}/java-environment/classpath/include/jni_md.h ${D}/usr/include
	install -d ${D}/usr/share/classpath
	install -m 0644 ${S}/java-environment/classpath/share/classpath/glibj.zip ${D}/usr/share/classpath
}

FILES_${PN} += "${libdir}/liblinkjvm-jni.so"
FILES_${PN} += "${libdir}/linkjvm-java.jar"

#jamvm
FILES_${PN} += "${bindir}/jamvm"
FILES_${PN} += "${includedir}/jni.h"
FILES_${PN} += "${libdir}/libjvm.la"
FILES_${PN} += "${libdir}/libjvm.so"
FILES_${PN} += "${libdir}/libjvm.so.0"
FILES_${PN} += "${libdir}/libjvm.so.0.0.0"
FILES_${PN} += "${libdir}/rt.jar"
FILES_${PN} += "${datadir}/jamvm"

#classpath
FILES_${PN} += "${includedir}/jawt.h"
FILES_${PN} += "${includedir}/jawt_md.h"
FILES_${PN} += "${includedir}/jni_md.h"
FILES_${PN} += "${libdir}/classpath"
FILES_${PN} += "${datadir}/classpath"

#ecj
FILES_${PN} += "${libdir}/ecj"
