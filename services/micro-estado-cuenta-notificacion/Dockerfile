# Usa la imagen oficial de Node.js
FROM node:18

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia los archivos de configuración y dependencias
COPY package.json package-lock.json ./

# Instala las dependencias
RUN npm install --omit=dev

# Copia el resto del código fuente
COPY . .

# Comando para ejecutar el servicio
CMD ["node", "notificar-estado-cuenta.js"]