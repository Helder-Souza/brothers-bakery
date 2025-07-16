# Use a imagem base do Python
FROM python:3.9

# Defina o diretório de trabalho
WORKDIR /app

# Copie o script de migrações e a pasta de migrações
COPY run_migrations.py /app/
COPY migrations /app/migrations

# Instale o pacote mysql-connector-python
RUN pip install mysql-connector-python

# Defina o comando padrão
CMD ["python", "/app/run_migrations.py"]
