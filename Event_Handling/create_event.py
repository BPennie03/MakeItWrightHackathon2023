import shutil
import datetime, pytz

# Method for reading input in from data file and parsing the data stream
#   Datastreams are fairly static and specific, may not work in all cases
def readDataFile():
    gtin = ""
    ed = ""
    ln = ""
    with open("ScannerData.txt") as f:
        data = f.read()
        gtin = f"{data[:16]}{data[32:43]}"
        ed = data[16:24]
        ln = data[24:32]

    # Example Datafile: 01108100559391971723050110TRT001211QH001006

    # Example input GTIN + Serial Number (Barcode Scan)
    #gtin = "0110810055939197211QH001005"
    gtin = f"{gtin[3:12]}.{gtin[2]}{gtin[12:15]}.{gtin[18:]}"
    
    # Final EPCIS format for GTIN
    #gtin = "081005593.1919.1QH001005"

    # Example GLN (Not included in scan)
    gln = "41408100559312932541293"
    gln = f"{gln[3:12]}.{gln[19:22]}.{gln[19:23]}"

    # Final EPCIS format for GLN
    #gln = "081005593.129.1293"

    # Example input Lot Number (Data Matrix)
    #ln = "10TRT001"
    ln = ln[2:]

    # Final EPCIS format for Lot Number
    #ln = "TRT001"

    # Example input Expiration Date (Data Matrix)
    #ed = "17230501"
    ed = f"20{ed[2:4]}-{ed[4:6]}-{ed[6:8]}"
    # Final EPCIS format for Lot Number
    #ed = "2023-05-01"

    # SSCC is not read in in this example, hardcoded value
    sscc = "081005593812000015"
    sscc = "810055938.01200001"
    return gtin, gln, ln, ed, sscc

# Uses readDataFile for filling in an EPCIS Template 
def updateXMLTemplate():
    template = input("What is the name of the EPCIS Template File? (.xml included): ")
    base =template.split("_")[0]
    new_name = f"{base}_Event.xml"
    shutil.copy(template, new_name)

    # Calculates needed date values
    date = datetime.datetime.now(pytz.timezone('America/New_York')).isoformat()
    tzOffset = "-05:00"
    creationDate = f"{date[:23]}Z"
    recordDate = f"{date[:23]}{tzOffset}"

    gtin, gln, ln, ed, sscc = readDataFile()
    REPLACE = ("CREATION_DATE","RECORD_DATE","TZ","GTIN","GLN","LN","ED","SSCC")
    ACTUAL = (creationDate,recordDate,tzOffset,gtin,gln,ln,ed,sscc)
    data = ""
    with open(new_name, 'r') as f:
        data = f.read()
    
    # Replaces all the keywords in the template with the real values
    with open (new_name, 'w') as f:
        for index, val_replace in enumerate(REPLACE):
            data = data.replace(val_replace, ACTUAL[index])
        f.write(data)

updateXMLTemplate()