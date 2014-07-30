#!/bin/sh
JAVA_HOME=/madams_sv/test/jdk1.6.0_43   ; export JAVA_HOME
# ƒpƒXî•ñ
PATH=$JAVA_HOME/bin:$PATH
export PATH

# java -cp testJava.jar per.kayu.test.Huge3
# java -Xdebug -Xrunjdwp:transport=dt_socket,address=9998,server=y,suspend=n -cp testJava.jar per.kayu.test.Huge3
java -agentlib:jdwp=transport=dt_socket,suspend=y,address=10.167.220.56:9999 -cp testJava.jar per.kayu.test.Huge3