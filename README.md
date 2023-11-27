# upload-download-files

`This a POC for a rest apis attached the data.sql to insert prerequest records`
## 1. create space

**URL** : `localhost:8080/api/space/create`

**Method** : `POST`

**first you should LOGING throught postman auth by provided credential attached with postman collection**

### 1.1. Request

```js
{
    "name":"stc-assessment",
    "permissionGroup":1,
    "path":"C:/Users/allam/Downloads/test"
}
```
### 1.2. Response

```json
{
  "status": "SUCCESS",
  "data": {
    "name": "stc-assessment",
    "id": 1
  }
}
```

## 2. Create folder

**URL** : `localhost:8080/api/folder/create`

**Method** : `POST`

**first you should LOGING throught postman auth by USER that has Edit access credentials**

### 2.1. Request

```js
{
    "name":"backend",
    "parentId":1
}
```
### 2.2. Response

```json
{
  "status": "SUCCESS",
  "data": {
    "name": "backend",
    "id": 2
  }
}
```

## 3. Upload file

**URL** : `localhost:8080/api/file/upload?name=assessment&parentId=2`

**Method** : `POST`

**This endpoint will Upload a multipart file**

### 3.1. Request

```js
{
  
}
```
### 3.2. Response

```json
{
  "status": "SUCCESS",
  "data": {
    "name": "assessment.pdf",
    "path": "C:/Users/allam/Downloads/test/stc-assessment/backend/assessment.pdf",
    "id": 1
  }
}
```

## 4. Download file

**URL** : `localhost:8080/api/file/download?name=assessmen.pdft&id=1`

**Method** : `GET`

**This endpoint will download a multipart file as a byte array**

### 4.1. Request

```js
{
  
}
```
### 4.2. Response

```json
%PDF-1.7
%����
1 0 obj
<</Type/Catalog/Pages 2 0 R/Lang(en-US) /StructTreeRoot 33 0 R/MarkInfo<</Marked true>>/Metadata 124 0 R/ViewerPreferences 125 0 R>>
endobj
2 0 obj
<</Type/Pages/Count 1/Kids[ 3 0 R] >>
endobj
3 0 obj
<</Type/Page/Parent 2 0 R/Resources<</Font<</F1 5 0 R/F2 9 0 R/F3 13 0 R/F4 18 0 R/F5 23 0 R/F6 25 0 R/F7 27 0 R>>/ExtGState<</GS7 7 0 R/GS8 8 0 R>>/ProcSet[/PDF/Text/ImageB/ImageC/ImageI] >>/Annots[ 11 0 R 12 0 R] /MediaBox[ 0 0 612 792] /Contents 4 0 R/Group<</Type/Group/S/Transparency/CS/DeviceRGB>>/Tabs/S/StructParents 0>>
endobj
4 0 obj
<</Filter/FlateDecode/Length 7041>>
stream
x��]�s�Fs�����LK>�`��d2�,'�c�N�4m�~�i�fL������뻻 ��%j5�0����nwoo�.y�:����O�%ٷ�&�GO�?>���)�N�$�G_�d1y��$��>|��;�i�'��>P�2���f�J�JC�Imrz���'�%�h2�g�|������`4<����@��ţ��&�/>x??|p����§��� J�D*�Ro-�����0�}	��J<�4�����D�
��ѦH��,
��{���5Ua��t���dh�3<��g�Ҹ�I��p��d!��$}"L�1y�{���ၦi���
һ���%|(yv�4I�K�Rs�0U��rz��ņ�5	�E����P��6y���e�����
`5��+P��=<�%yFz�ӻ��B�S�
�}[+sm��]�mt^�ª�z�(�u��w���j��1d����_��h-���^�$��"p�k������z��]&*��ۚ(�SU-����&�i��/4�%MD:9�"�|�Nk�D�99��t>�ϝ�&�Cܣp>���l����𲁗w3���Y������
�^ϛK�ە�-���9
��?��݁���2�V|�æ5Y�����_=��x:[ѻW�����������v��b8C�i>�f����w'�Y�|�$V���^�(�Q۬���w��*���y�N˖Z����[}&�l4�I�$��}�r���H���'|a����>^e�%�?J���8���!�s||'=�
```

## 5. File metadata

**URL** : `http://localhost:8080/api/file/metadata/3`

**Method** : `GET`

**This endpoint will get file metadata**

### 5.1. Request

```js
{
  
}
```
### 5.2. Response

```json
{
    "status": "SUCCESS",
    "data": {
        "id": 3,
        "name": "assessment.pdf",
        "path": "C:/Users/allam/Downloads/test/stc-assessment/backend/assessment.pdf"
    }
}
```

