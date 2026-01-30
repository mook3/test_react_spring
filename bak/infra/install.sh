helmfile -f helmfile.yaml.gotmpl -e dev destroy
kubectl delete ns hello-spring-dev --ignore-not-found || exit 1
kubectl create ns hello-spring-dev || exit 1

helmfile -f helmfile.yaml.gotmpl -e dev apply || exit 1
