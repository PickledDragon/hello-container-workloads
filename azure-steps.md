1. Build locally
```shell
mvn clean package
```
2. Build docker image and run
```shell
docker build . -t container-demo:1.0
docker run -d -p 8080:8080 container-demo:1.0
```
3. Alternative option: Build using Azure tools and push to ACR.
```shell
az login
az acr build --image container-demo:1.0 --registry pickleddragon .
```

Start AKS cluster
```shell
az aks start --name democluster --resource-group demo-ing
```

Setting up github workflow

Get your credentials from azure
```shell
az ad sp create-for-rbac --name "myApp" --role contributor --scopes /subscriptions/<SUBSCRIPTION_ID>/resourceGroups/<RESOURCE_GROUP> --sdk-auth
```