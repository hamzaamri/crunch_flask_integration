DESCRIPTION = "Crunch Chat Application Packagegroup"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
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
    crunch \
"