kubectl apply -f ns.yml
kubectl apply -f postgres.yml
kubectl apply -f backend.yml
#kubectl wait --for=condition=Ready svc/backend
kubectl apply -f frontend.yml
kubectl apply -f ingress.yml
