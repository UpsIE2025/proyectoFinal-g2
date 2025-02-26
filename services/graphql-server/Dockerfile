# 1. Usa una imagen oficial de Node.js (versión estable recomendada)
FROM node:18

# 2. Establece el directorio de trabajo dentro del contenedor
WORKDIR /usr/src/app

# 3. Copia package.json y package-lock.json para instalar dependencias primero
COPY package*.json ./

# 4. Instala dependencias sin generar archivos adicionales
RUN npm install --only=production

# 5. Copia el código fuente del proyecto al contenedor
COPY . .

# 6. Expone el puerto en el que corre Apollo Server (normalmente 4000)
EXPOSE 4000

# 7. Comando para ejecutar el servidor GraphQL
CMD ["node", "src/index.js"]
