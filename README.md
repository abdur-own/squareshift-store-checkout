# squareshift-store-checkout
Checkout different products.
# squareshift-store-checkout
Checkout different products API Details:
1. getCartItems (url -/cart/items)- This will return list of all product whose product ids are 100 to 119.

2. saveCartItem (url- /cart/item) - Takes one product details as request body and just return success or updated according to the product id.

3. getCheckoutValue -(/cart/checkout-value) - This will calculate total discount, total weight, shiping cost,finally total amount.
   here the product which will be taken into account is the last disgit in the postal code passed. let say
   user sends 465535 as postal code, then 5 product with product ids 100, 101, 102,103,104,105 will be considered as present in the cart 
   and everything will be calculate. This is done to check the variation of product details.

4. Delete api: this returns success if product is deleted. Here Cart id or user id is required for deleting a particular user cart items or if there 
is only one cart per user then user id will work.

5. swagger UI url: http://localhost:8084/api/v1/swagger-ui/index.html
   
   # Docs for the Azure Web Apps Deploy action: https://github.com/Azure/webapps-deploy
# More GitHub Actions for Azure: https://github.com/Azure/actions

name: Build and deploy JAR app to Azure Web App - Spring-azure-demo-ab

on:
  push:
    branches:
      - main
  workflow_dispatch:

jobs:
  build:
    runs-on: windows-latest

    steps:
      - uses: actions/checkout@v2

      - name: Set up Java version
        uses: actions/setup-java@v1
        with:
          java-version: '17'

      - name: Build with Maven
        run: mvn clean install

      - name: Upload artifact for deployment job
        uses: actions/upload-artifact@v2
        with:
          name: java-app
          path: '${{ github.workspace }}/target/*.jar'

  deploy:
    runs-on: windows-latest
    needs: build
    environment:
      name: 'production'
      url: ${{ steps.deploy-to-webapp.outputs.webapp-url }}

    steps:
      - name: Download artifact from build job
        uses: actions/download-artifact@v2
        with:
          name: java-app

      - name: Deploy to Azure Web App
        id: deploy-to-webapp
        uses: azure/webapps-deploy@v2
        with:
          app-name: 'Spring-azure-demo-ab'
          slot-name: 'production'
          publish-profile: ${{ secrets.AzureAppService_PublishProfile_e101348274e0415cbbc3b8fc2c3d9f93 }}
          package: '*.jar'
