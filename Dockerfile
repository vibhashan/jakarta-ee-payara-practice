FROM payara/server-web:latest
COPY target/*.war $DEPLOY_DIR
