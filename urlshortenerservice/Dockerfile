
#
#   Docker file defining image for URL Shortener Service Docker Container
#


ARG BASE_IMAGE_TAG
FROM openjdk:${BASE_IMAGE_TAG:-11}


COPY ./target/universal/urlshortenerservice-2.6.x.zip .

RUN unzip urlshortenerservice-2.6.x.zip && \
    ls urlshortenerservice-2.6.x/bin

WORKDIR urlshortenerservice-2.6.x

EXPOSE 9000

CMD ["bin/urlshortenerservice", "-Dplay.http.secret.key=6Z<_Xo^9QUAspP`rE6v@KF[KofLo`bLJs73c8`84SdYeLcMDCu_LdLoV;os@x;wj"]