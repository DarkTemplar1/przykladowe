import cv2
from cvzone.HandTrackingModule import HandDetector

cap = cv2.VideoCapture(0)
detector = HandDetector()

while True:
    success, image = cap.read()

    hands, _ = detector.findHands(image)

    # checking whether a hand is detected
    if hands:
        for hand in hands:  # working with each hand
            for id, lm in enumerate(hand):
                h, w, c = image.shape
                cx, cy = int(lm[0] * w), int(lm[1] * h)
                if id == 20:
                    cv2.circle(image, (cx, cy), 25, (255, 0, 255), cv2.FILLED)

            detector.drawHands(image)

    cv2.imshow("Output", image)
    cv2.waitKey(1)
