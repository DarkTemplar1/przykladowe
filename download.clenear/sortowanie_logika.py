import os
import shutil

def sortuj_pliki(folder_pobrane):
    # Definicje rozszerzeń i nazw folderów docelowych
    foldery_docelowe = {
        'Obrazy': ['.jpg', '.jpeg', '.png', '.gif'],
        'Dokumenty': ['.pdf', '.doc', '.docx', '.txt'],
        'Filmy': ['.mp4', '.avi', '.mkv'],
        'Muzyka': ['.mp3', '.wav', '.flac'],
        # Dodaj inne kategorie według potrzeb
    }

    # Stwórz foldery docelowe na pulpicie, jeśli nie istnieją
    folder_pulpit = os.path.join(os.path.expanduser("~"), "OneDrive", "Pulpit")

    for folder, rozszerzenia in foldery_docelowe.items():
        folder_docelowy = os.path.join(folder_pulpit, folder)
        if not os.path.exists(folder_docelowy):
            os.makedirs(folder_docelowy)

    # Przeiteruj przez listę plików i przenieś je do odpowiednich folderów
    for plik in os.listdir(folder_pobrane):
        pelna_sciezka = os.path.join(folder_pobrane, plik)
        if os.path.isfile(pelna_sciezka):
            for folder_docelowy, rozszerzenia in foldery_docelowe.items():
                if any(plik.lower().endswith(rozszerzenie) for rozszerzenie in rozszerzenia):
                    sciezka_docelowa = os.path.join(folder_pulpit, folder_docelowy)
                    shutil.move(pelna_sciezka, os.path.join(sciezka_docelowa, plik))
                    break
