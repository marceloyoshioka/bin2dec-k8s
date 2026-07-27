---

## 📌 Visão Geral da API

A API realiza a conversão de números binários para decimais e disponibiliza documentação interativa através do Swagger UI.

| Recurso | Endpoint |
|---------|----------|
| **Swagger UI** | `http://localhost:30080/swagger-ui/index.html` |
| **Conversão** | `GET /api/v1/convert?bin={numero_binario}` |

---

# 🐳 Docker

A aplicação foi containerizada utilizando **Docker** com **Multi-Stage Build**, produzindo uma imagem otimizada para execução.

### Principais etapas

- Build da imagem Docker
- Execução local para validação
- Publicação da imagem no Docker Hub

```bash
docker build -t petersonmarcelo/bin2dec-api:v1.0 .
docker run -d -p 8080:8080 --name bin2dec-container petersonmarcelo/bin2dec-api:v1.0
docker push petersonmarcelo/bin2dec-api:v1.0
```

---

# ☸️ Kubernetes

Após a publicação da imagem, a aplicação foi implantada em um cluster Kubernetes utilizando manifestos declarativos.

## Recursos utilizados

- **Pod** para execução inicial da aplicação.
- **Service (NodePort)** para exposição da API.
- **Deployment** com duas réplicas para alta disponibilidade.
- **ConfigMap** para externalização das configurações.

---

# 🧪 Experimentos Realizados

Durante o desenvolvimento foram realizados alguns experimentos para validar o funcionamento do Kubernetes.

| Experimento | Objetivo |
|-------------|----------|
| **Self-Healing** | Verificar a recriação automática de Pods após falhas. |
| **Requests & Limits** | Controlar o consumo de CPU e memória da aplicação. |
| **ConfigMap** | Separar configurações da imagem Docker e do código-fonte. |

---

# 📁 Estrutura dos Manifestos

| Arquivo | Finalidade |
|----------|------------|
| `configmap.yaml` | Variáveis de ambiente da aplicação |
| `deployment.yaml` | Deployment com 2 réplicas e limites de recursos |
| `svc-bin2dec-nodeport.yaml` | Exposição da API através de um Service NodePort |

---

# 🚀 Executando o Projeto

Aplicar todos os manifestos:

```bash
kubectl apply -f k8s/
```

Verificar os recursos:

```bash
kubectl get all
```

Remover todos os recursos:

```bash
kubectl delete -f k8s/
```

---

# 🎯 Conceitos Praticados

- ✅ Docker e Multi-Stage Build
- ✅ Publicação de imagens no Docker Hub
- ✅ Pods
- ✅ Deployments
- ✅ Services (NodePort)
- ✅ ConfigMaps
- ✅ Self-Healing
- ✅ Requests e Limits
- ✅ Gerenciamento de réplicas
- ✅ Externalização de configurações
