DESCRIPTION = "Crunch Chat Application"
HOMEPAGE = "https://github.com/pri1311/crunch"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=97904f8e9fd003725a5ed65cbb0dd5ec"

SRCREV = "2ac8a741bc8dd8bd141288dcb1b31e31c9421cbe"   

SRC_URI = "git://github.com/pri1311/crunch.git;protocol=https;branch=master \
           file://cloudinary-setup.sh \
           file://crunch.service"

RDEPENDS_${PN} = " \
    python3-flask \
    python3-requests \
    python3-bidict \
    python3-certifi \
    python3-click \
    python3-flask-login \
    python3-flask-socketio \
    python3-flask-sqlalchemy \
    python3-itsdangerous \
    python3-jinja2 \
    python3-markupsafe \
    python3-python-engineio \
    python3-python-socketio \
    python3-six \
    python3-sqlalchemy \
    python3-urllib3 \
    python3-werkzeug \
    python3-gunicorn \
    python3-pip \
"

S = "${WORKDIR}/git"

do_install() {
    # Executables
    install -d ${D}${bindir}
    install -m 0755 ${S}/main.py ${D}${bindir}/crunch

    # Python Libraries
    install -d ${D}${libdir}/crunch
    install -m 0644 ${S}/website/*.py ${D}${libdir}/crunch/

    # Templates
    install -d ${D}${datadir}/myapp/templates
    cp -r ${S}/website/templates/* ${D}${datadir}/myapp/templates/

    # Static files
    install -d ${D}${datadir}/myapp/static/css
    cp -r ${S}/website/static/css/* ${D}${datadir}/myapp/static/css/
    
    install -d ${D}${datadir}/myapp/static/js
    cp -r ${S}/website/static/js/* ${D}${datadir}/myapp/static/js/
    
    install -d ${D}${datadir}/myapp/static/images
    cp -r ${S}/website/static/images/* ${D}${datadir}/myapp/static/images/

    # Documentation
    install -d ${D}${datadir}/doc/myapp
    install -m 0644 ${S}/LICENSE.md ${D}${datadir}/doc/myapp/
    install -m 0644 ${S}/readme.md ${D}${datadir}/doc/myapp/

    # Database
    install -d ${D}/var/lib/myapp
    install -m 0644 ${S}/website/db.sqlite ${D}/var/lib/myapp/
}

FILES:${PN} += " \
    ${libdir}/crunch \
    ${datadir}/myapp/templates \
    ${datadir}/myapp/static \
    ${datadir}/doc/myapp \
    ${systemd_unitdir}/system/crunch.service \
"

SYSTEMD_SERVICE:${PN} = "crunch.service"