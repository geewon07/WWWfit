// Give the service worker access to Firebase Messaging.
// Note that you can only use Firebase Messaging here, other Firebase libraries
// are not available in the service worker.
importScripts("https://www.gstatic.com/firebasejs/8.6.5/firebase-app.js");
importScripts("https://www.gstatic.com/firebasejs/8.6.5/firebase-messaging.js");

// Initialize the Firebase app in the service worker by passing in the
// messagingSenderId.
firebase.initializeApp({
  apiKey: "AIzaSyAf1RTS3Mb101hGxSd70lfpH4vPkDSpK3k",
  projectId: "fit-66c29",
  messagingSenderId: "1000689444688",
  appId: "1:1000689444688:web:c2175b4ffda57d727bae55",
});

// Retrieve an instance of Firebase Messaging so that it can handle background
// messages.
const messaging = firebase.messaging();
// 백그라운드 상태에서 받은 알림 처리
self.addEventListener("notificationclick", function (event) {
  event.notification.close();
  event.waitUntil(clients.openWindow("http://localhost:8080/"));
});

messaging.setBackgroundMessageHandler((payload) => {
  console.log(
    "[firebase-messaging-sw.js] Received background message ",
    payload,
    payload.data.content,
    payload.data.title,
    payload.data.url
  );
  // Customize notification here
  const notificationTitle = payload.data.title;
  const notificationOptions = {
    body: payload.data.content,
    icon: "/firebase-logo.png",
    data: {
      url: payload.data.url,
    },
  };

  return self.registration.showNotification(
    notificationTitle,
    notificationOptions
  );
});
