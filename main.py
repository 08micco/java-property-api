import requests


def get_all_properties():
    url = "http://localhost:8080/api/properties"
    headers = {"Accept": "application/json"}

    response = requests.get(url, headers=headers)

    print(response.status_code)
    print(response.json())  # Print the response JSON

def get_property_by_id(property_id):
    url = f"http://localhost:8080/api/properties/{property_id}"
    headers = {"Accept": "application/json"}

    response = requests.get(url, headers=headers)

    print(response.status_code)
    print(response.json())

def add_property():
    url = "http://localhost:8080/api/properties"
    headers = {"Content-Type": "application/json"}
    data = {
        "address": "Kollegievej 6U",
        "propertyType": "Apartment",
        "owner": "Síggi Wissing",
        "propertyAssessment": 200000.00
    }

    response = requests.post(url, json=data, headers=headers)

    print(response.status_code)
    print(response.json())

def update_property(property_id):
    url = f"http://localhost:8080/api/properties/{int(property_id)}"
    headers = {"Content-Type": "application/json"}
    data = {
        "id": property_id,
        "address": "Kollegievej 2B, 8- 3",
        "propertyType": "Apartment",
        "owner": "Mikkel Wissing",
        "propertyAssessment": 300000.00
    }

    response = requests.put(url, json=data, headers=headers)

    print(response.status_code)
    print(response.json())

def delete_property(property_id):
    url = f"http://localhost:8080/api/properties/{property_id}"

    response = requests.delete(url)

    print(response.status_code)






add_property()
#update_property(2)
#delete_property(2)