FROM hub.c.163.com/library/node

# Create app directory
WORKDIR /bts_repo_api

# Install app dependencies
COPY package*.json ./

RUN npm install
# Copy app source code

COPY . .

#Expose port and start application
EXPOSE 3030

CMD [ "npm", "start" ]