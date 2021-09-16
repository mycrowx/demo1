FROM python:3.9-alpine
COPY main.py main.py
COPY requirement.txt requirement.txt
RUN python -m pip install -r requirement.txt
# ADD entrypoint.sh entrypoint.sh
ADD wait-for-it.sh wait-for-it.sh
# CMD [ "entrypoint.sh" ]
# ENTRYPOINT ["sh"]
