FROM airhacks/glassfish
COPY ./target/HelloTodo.war ${DEPLOYMENT_DIR}
