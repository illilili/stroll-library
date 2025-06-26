# 

## Model
www.msaez.io/#/101322304/storming/0e669debb8a05f7e1e583d985041b8b93

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- WriterManagement
- ContentPublication
- SubscriptionAndPoint
- AIServices
- PlatformOrchestration


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- WriterManagement
```
 http :8088/writerProfiles requestId="requestId"writerName="writerName"email="email"introduction="introduction"portfolioUrl="portfolioUrl"submittedAt="submittedAt"reviewedAt="reviewedAt"reviewedBy="reviewedBy"reviewComment="reviewComment"
 http :8088/portfolios portfolioId="portfolioId"writerId="writerId"portfolioUrl="portfolioUrl"createdAt="createdAt"
```
- ContentPublication
```
 http :8088/contents contentId="contentId"writerId="writerId"title="title"summary="summary"keywords="keywords"body="body"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/publicationRequests publicationRequestId="publicationRequestId"contentId="contentId"requestDate="requestDate"coverImageUrl="coverImageUrl"summary="summary"category="category"subscriptionPrice="subscriptionPrice"epubUrl="epubUrl"pdfUrl="pdfUrl"
 http :8088/publicationMetadata publicationMetadataId="publicationMetadataId"contentId="contentId"coverImageUrl="coverImageUrl"summary="summary"category="category"subscriptionPrice="subscriptionPrice"epubUrl="epubUrl"pdfUrl="pdfUrl"createdAt="createdAt"updatedAt="updatedAt"
```
- SubscriptionAndPoint
```
 http :8088/promotionMessages promotionMessageId="promotionMessageId"message="message"displayedAt="displayedAt"createdAt="createdAt"
 http :8088/users userId="userId"name="name"ktCustomer="ktCustomer"points="points"
 http :8088/pointWallets pointWalletId="pointWalletId"userId="userId"ktCustomer="ktCustomer"points="points"
 http :8088/subscriptions subscriptionId="subscriptionId"userId="userId"startDate="startDate"endDate="endDate"
```
- AIServices
```
 http :8088/coverImages coverImageId="coverImageId"manuscriptId="manuscriptId"imageUrl="imageUrl"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/summaries summaryId="summaryId"manuscriptId="manuscriptId"content="content"
 http :8088/convertedManuscripts convertedManuscriptId="convertedManuscriptId"manuscriptId="manuscriptId"epubUrl="epubUrl"pdfUrl="pdfUrl"convertedAt="convertedAt"
 http :8088/categoryAndFees categoryAndFeeId="categoryAndFeeId"manuscriptId="manuscriptId"bookId="bookId"category="category"feeAmount="feeAmount"currency="currency"generatedAt="generatedAt"
```
- PlatformOrchestration
```
 http :8088/books bookId="bookId"title="title"viewCount="viewCount"bestsellerBadge="bestsellerBadge"
 http :8088/badges badgeId="badgeId"grantedAt="grantedAt"
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
