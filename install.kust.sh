function docker_tag_push() {
    (( $# == 1 )) || { echo 'Most specify image name'; return 1; }
    docker tag "$1":latest mook3/test:"$1" || return 1
    docker push mook3/test:"$1" || return 1
}

docker compose build || exit 1
docker_tag_push hello-backend || exit 1
docker_tag_push hello-frontend || exit 1

#helmfile -f infra/helmfile.yaml.gotmpl -e dev destroy
#kubectl delete ns hello-spring-dev --ignore-not-found || exit 1
#kubectl create ns hello-spring-dev || exit 1

#helmfile -f infra/helmfile.yaml.gotmpl -e dev apply

kubectl apply -k kustomize_yml/overlays/dev || exit 1
