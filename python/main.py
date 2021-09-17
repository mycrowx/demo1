import uvicorn
import requests
from fastapi import FastAPI
import py_eureka_client.eureka_client as eureka_client

app = FastAPI(title="Hello python", description="Greetting Python", version="0.1.0")

eureka_client.init(
    eureka_server="http://demo1-discovery:9999",
    app_name="python",
    instance_port=8012,
)


def get_url(url):
    return url


@app.get("/hello-user")
def hello_user():
    url = eureka_client.walk_nodes("user", "/user", walker=get_url)

    res = requests.get(url)
    data = res.json()
    return data


if __name__ == "__main__":
    uvicorn.run(app, host="0.0.0.0", port=8012)
