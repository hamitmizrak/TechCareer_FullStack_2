import i18n from 'i18next';
import {initReactI18next} from 'react-i18next';

i18n.use(initReactI18next).init({
    resources: {
        en:
            {
                translations: {
                    'id': 'ID',
                    'category_name': 'Category Name',
                    'date': 'Date',
                    'update': 'Update',
                    'delete': 'Delete',
                    'view': 'View',
                }
            },
        tr:
            {
                translations: {
                    'id': 'ID',
                    'category_name': 'Kategori Adı',
                    'date': 'Tarih',
                    'update': 'Güncelle',
                    'delete': 'Sil',
                    'view': 'Göster',
                }
            }
    },
    fallbackLng: 'tr',    //fallbackLng: 'en', fall back function    
    ns: ['translations'], //kelimeleri nerede alsın
    defaultNS: 'translations',
    keySeparator: false,
    interpolation: {escapeValue: false, formatSeparator: ','},
    react: {
        wait: true
    }
});
export default i18n;