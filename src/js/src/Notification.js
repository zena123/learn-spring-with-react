import { notification } from "antd";

// const [api] = notification.useNotification();
  const openNotification = (type, message, description) => {
    notification[type]({
      message: message,
      description:
        description,
  })};

  export const successNotification = (message, description) =>
   openNotification('success', message, description);

   export const infoNotification = (message, description) =>
   openNotification('info', message, description);

   export const warningNotification = (message, description) =>
   openNotification('warning', message, description);


   export const errorsNotification = (message, description) =>
   openNotification('error', message, description);