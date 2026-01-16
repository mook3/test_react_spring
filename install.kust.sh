function docker_tag_push() {
    (( $# == 1 )) || { echo 'Most specify image name'; return 1; }
    docker tag "$1":latest mook3/test:"$1"
    docker push mook3/test:"$1"
}

docker compose build || exit 1
docker_tag_push hello-backend || exit 1
docker_tag_push hello-frontend || exit 1

kubectl delete ns hello-spring --ignore-not-found || exit 1

kubectl apply -k kustomize_yml/overlays/dev
