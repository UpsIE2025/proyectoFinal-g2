# Use official Node.js image
FROM node:18

# Set working directory inside the container
WORKDIR /usr/src/app

# Copy package.json and package-lock.json first for efficient caching
COPY package*.json ./

# Install only production dependencies
RUN npm install --only=production

# Copy all source code
COPY . .

# Expose the port (matches the one used in app.js/index.js)
EXPOSE 3000

# Start the microservice
CMD ["node", "src/index.js"]
